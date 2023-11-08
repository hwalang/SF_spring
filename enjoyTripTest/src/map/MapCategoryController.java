package map;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import common.DBManager;

@WebServlet("/mapCategory")
public class MapCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);

		switch (action) {
		case "gugun":
			findGugun(request, response);
			break;
		case "tripDetail":
			goTripDetail(request, response);
			break;
		case "kakaoPin":
			kakaoPin(request, response);
			break;
		case "overview":
			getOverview(request, response);
			break;
		}

	}

	private void getOverview(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MapCategory: getOverview");

		String strContentId = request.getParameter("content_id");
		int contentId = Integer.parseInt(strContentId);
		
		// content_id를 이용해서 overview를 얻는다.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String overview = null;
		Gson gson = new Gson();
		// gugun 데이터 모두 가져오기
		try {
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("select overview from attraction_description where content_id=?;");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, contentId);
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				overview = rs.getString("overview");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		String jsonStr = gson.toJson(overview);
		System.out.println(jsonStr);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonStr);

	}

	private void goTripDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("goTripDetail");

		String contentId = request.getParameter("content_id");
		System.out.println(contentId);

		// content_id를 이용해서 관광지 정보를 얻는다.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		KakaoMapDto dto = null;

		// gugun 데이터 모두 가져오기
		try {
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select content_id, title, addr1, addr2, first_image, sido_code, gugun_code, latitude, longitude ")
					.append(" from attraction_info WHERE content_id=?;");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, Integer.parseInt(contentId));
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				int content_id = rs.getInt("content_id");
				String title = rs.getString("title");
				String addr1 = rs.getString("addr1");
				String addr2 = rs.getString("addr2");
				String first_image = rs.getString("first_image");
				int sido_code = rs.getInt("sido_code");
				int gugun_code = rs.getInt("gugun_code");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");

				// 데이터가 있으면 추가
				dto = new KakaoMapDto(content_id, title, addr1, addr2, first_image, sido_code, gugun_code, latitude,
						longitude);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		System.out.println(dto);
		request.getSession().setAttribute("tripDetail", dto);
		request.getRequestDispatcher("/tripDetail.jsp").forward(request, response);
	}

	private void kakaoPin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MapCategory: kakaoPin");

		String sidoCode = request.getParameter("sido");
		String gugunCode = request.getParameter("gugun");
		System.out.println(sidoCode + " " + gugunCode);

		// 모든 관광지의 content_id, title, addr1, addr2, first_image, sido_code, gugun_code,
		// latitude, longitude 정보를 가져와서 핀을 찍는다.
		// 위도 경도를 positions 배열에 담아서 response 한다.
		// DB 검색
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<KakaoMapDto> mapList = new ArrayList<>();

		// gugun 데이터 모두 가져오기
		try {
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append(
					"select content_id, title, addr1, addr2, first_image, sido_code, gugun_code, latitude, longitude ")
					.append(" from attraction_info WHERE sido_code=? AND gugun_code=?;");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, Integer.parseInt(sidoCode));
			pstmt.setInt(2, Integer.parseInt(gugunCode));
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int content_id = rs.getInt("content_id");
				String title = rs.getString("title");
				String addr1 = rs.getString("addr1");
				String addr2 = rs.getString("addr2");
				String first_image = rs.getString("first_image");
				int sido_code = rs.getInt("sido_code");
				int gugun_code = rs.getInt("gugun_code");
				double latitude = rs.getDouble("latitude");
				double longitude = rs.getDouble("longitude");

				// 데이터가 있으면 추가
				// KakaoMapDto temp = new KakaoMapDto(content_id, title, sidoCode);
				mapList.add(new KakaoMapDto(content_id, title, addr1, addr2, first_image, sido_code, gugun_code,
						latitude, longitude));
				// System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		// json 데이터 내리기
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();

		for (int i = 0; i < mapList.size(); ++i) {
			KakaoMapDto dto = mapList.get(i);
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("content_id", dto.getContentId());
			jsonObject.addProperty("title", dto.getTitle());
			jsonObject.addProperty("addr1", dto.getAddr1());
			jsonObject.addProperty("addr2", dto.getAddr2());
			jsonObject.addProperty("first_image", dto.getFirstImageURL());
			jsonObject.addProperty("sido_code", dto.getSidoCode());
			jsonObject.addProperty("gugun_code", dto.getGugunCode());
			jsonObject.addProperty("latitude", dto.getLatitude());
			jsonObject.addProperty("longitude", dto.getLongitude());
			jsonArray.add(jsonObject);
		}

		String jsonStr = gson.toJson(jsonArray);
		System.out.println(jsonStr);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonStr);
	}

	private void findGugun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("findGugun");

		String selectSidoCode = request.getParameter("select");
		System.out.println(selectSidoCode);

		// DB 검색
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<GugunDto> gugunlist = new ArrayList<>();
		int sido_code = -1;

		// gugun 데이터 모두 가져오기
		try {
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("select gugun_code, gugun_name, sido_code from gugun");
			pstmt = con.prepareStatement(sb.toString());
			System.out.println(pstmt.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int gugunCode = rs.getInt("gugun_code");
				String gugunName = rs.getString("gugun_name");
				int sidoCode = rs.getInt("sido_code");

				// 데이터가 있으면 추가
				// GugunDto temp = new GugunDto(gugunCode, gugunName, sidoCode);
				gugunlist.add(new GugunDto(gugunCode, gugunName, sidoCode));
				// System.out.println(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		Connection con1 = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;

		// 각 DTO에서 getSido_code를 가져와서 비교한다.
		try {
			con1 = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("select sido_code from sido where sido_code=?;");
			pstmt1 = con1.prepareStatement(sb.toString());
			pstmt1.setInt(1, Integer.parseInt(selectSidoCode));
			rs1 = pstmt1.executeQuery();
			System.out.println(pstmt1.toString());

			if (rs1.next()) {
				sido_code = rs1.getInt("sido_code");
				System.out.println("sido_code: " + sido_code);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs1, pstmt1, con1);
		}

		List<GugunDto> result = new ArrayList<>();
		for (int i = 0; i < gugunlist.size(); ++i) {
			GugunDto dto = gugunlist.get(i);
			if (sido_code == dto.getSido_code()) {
				result.add(dto);
			}
		}

		// json 데이터 내리기
		Gson gson = new Gson();
		JsonArray jsonArray = new JsonArray();

		for (int i = 0; i < result.size(); ++i) {
			GugunDto _gugun = result.get(i);
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("gugunCode", _gugun.getGugun_code());
			jsonObject.addProperty("gugunName", _gugun.getGugun_name());
			jsonObject.addProperty("sidoCode", _gugun.getSido_code());
			jsonArray.add(jsonObject);
		}

		String jsonStr = gson.toJson(jsonArray);
		System.out.println(jsonStr);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonStr);
	}

}
