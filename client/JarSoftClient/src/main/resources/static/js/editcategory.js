const hostName = window.location.protocol; // отделяем адрес хоста
const fullBannerPathname = window.location.pathname; // отделяем весь url после хоста
const categoryId = fullBannerPathname.split('page/')[1]; // оставляем все то, что находится после
const api_url = hostName + '/edit/category/' + categoryId; // url с json



async function getCategoryData() {

    const response = await fetch(api_url); // как парсить json https://www.youtube.com/watch?v=uxf0--uiX0I
    const data = await response.json();
    const {id, name} = data;

    document.getElementById('id').textContent = id;
    document.getElementById('inputCategory').value = name;


}

getCategoryData().then();