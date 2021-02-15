const hostName = window.location.protocol; // отделяем адрес хоста
const fullBannerPathname = window.location.pathname; // отделяем весь url после хоста
const bannerId = fullBannerPathname.split('page/')[1]; // оставляем все то, что находится после
const api_url = hostName + '/banner/' + bannerId; // url с json

async function getBannerData() {

    const response = await fetch(api_url); // как парсить json https://www.youtube.com/watch?v=uxf0--uiX0I
    const data = await response.json();
    const {category, name, price, content} = data;

    document.getElementById('category').textContent = category.name;
    document.getElementById('name').textContent = name;
    document.getElementById('content').textContent = content;
    document.getElementById('price').textContent = price;
}

getBannerData().then()



