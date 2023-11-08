//let numOfRows = 12;
//let pageNo = 1;
//let areaCode = "";
//let sigunguCode = "";
//let cat1 = "";
//let cat2 = "";
//let cat3 = "";
//
//window.onload = async function () {
//  showSpinner(true);
//
//  await getArea1List();
//  await getCat1List();
//
//  document.querySelector("#btnSearch").onclick = function () {
//    sigunguCode = document.querySelector("#area2List").value;
//    cat3 = document.querySelector("#cat3List").value;
//    getList();
//  };
//
//  showSpinner(false);
//};
//
//async function getList() {
//  let url = `http://localhost:8080/WebBasic/trip/list`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}&areaCode=${areaCode}&sigunguCode=${sigunguCode}&cat1=${cat1}&cat2=${cat2}&cat3=${cat3}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let itemList = data.response.body.items.item;
//  itemListHtml = ``;
//
//  itemList.forEach((item) => {
//    console.log(item);
//    itemListHtml += `
//                <div class="col-3">
//                    <div class="card">
//                        <img src="${item.firstimage}" class="card-img-top" alt="${item.title}">
//                        <div class="card-body">
//                            <h5 class="card-title">${item.title}</h5>
//                            <p class="card-text">${item.addr1}</p>
//                            <a href="#" class="btn btn-primary">Go</a>
//                        </div>
//                    </div>
//                </div>
//                `;
//  });
//
//  document.querySelector("#itemList").innerHTML = itemListHtml;
//}
//
//async function getArea1List() {
//  let url = `http://localhost:8080/WebBasic/trip/areaCode`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let codeList = data.response.body.items.item;
//  console.log(codeList);
//
//  let listHtml = `<option value=''>시도를 선택하세요</option>`;
//  codeList.forEach((el) => {
//    listHtml += `<option value='${el.code}'>${el.name}</option>`;
//  });
//  document.querySelector("#area1List").innerHTML = listHtml;
//
//  // change event handler
//  document.querySelector("#area1List").onchange = function (e) {
//    areaCode = e.target.value;
//    getArea2List();
//  };
//}
//
//async function getArea2List() {
//  let url = `http://localhost:8080/WebBasic/trip/areaCode`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}&areaCode=${areaCode}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let codeList = data.response.body.items.item;
//  console.log(codeList);
//
//  let listHtml = `<option value=''>구군을 선택하세요</option>`;
//  codeList.forEach((el) => {
//    listHtml += `<option value='${el.code}'>${el.name}</option>`;
//  });
//  document.querySelector("#area2List").innerHTML = listHtml;
//}
//
//async function getCat1List() {
//  let url = `http://localhost:8080/WebBasic/trip/categoryCode`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let codeList = data.response.body.items.item;
//  console.log(codeList);
//
//  let listHtml = `<option value=''>대분류 선택하세요</option>`;
//  codeList.forEach((el) => {
//    listHtml += `<option value='${el.code}'>${el.name}</option>`;
//  });
//  document.querySelector("#cat1List").innerHTML = listHtml;
//
//  // change event handler
//  document.querySelector("#cat1List").onchange = function (e) {
//    cat1 = e.target.value;
//    getCat2List();
//  };
//}
//
//async function getCat2List() {
//  let url = `http://localhost:8080/WebBasic/trip/categoryCode`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}&cat1=${cat1}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let codeList = data.response.body.items.item;
//  console.log(codeList);
//
//  let listHtml = `<option value=''>중분류 선택하세요</option>`;
//  codeList.forEach((el) => {
//    listHtml += `<option value='${el.code}'>${el.name}</option>`;
//  });
//  document.querySelector("#cat2List").innerHTML = listHtml;
//
//  // change event handler
//  document.querySelector("#cat2List").onchange = function (e) {
//    cat2 = e.target.value;
//    getCat3List();
//  };
//}
//
//async function getCat3List() {
//  let url = `http://localhost:8080/WebBasic/trip/categoryCode`;
//  let urlParams = `?numOfRows=${numOfRows}&pageNo=${pageNo}&cat1=${cat1}&cat2=${cat2}`;
//
//  let response = await fetch(url + urlParams);
//  let data = await response.json();
//  console.log(data);
//
//  let codeList = data.response.body.items.item;
//  console.log(codeList);
//
//  let listHtml = `<option value=''>소분류 선택하세요</option>`;
//  codeList.forEach((el) => {
//    listHtml += `<option value='${el.code}'>${el.name}</option>`;
//  });
//  document.querySelector("#cat3List").innerHTML = listHtml;
//}
//
//const spinner = document.querySelector("#spinner");
//function showSpinner(flag) {
//  if (flag) {
//    spinner.classList.remove("hide");
//  } else {
//    spinner.classList.add("hide");
//  }
//}
