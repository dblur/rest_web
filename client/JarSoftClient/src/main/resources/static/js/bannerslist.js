const hostName = window.location.protocol;
const api_url = hostName + '/banners';

async function getBannerListData() {

    const response = await fetch(api_url);
    const list = await response.json(); // парсим json

    buildTable(list)

    function buildTable(data) {
        const table = document.getElementById('myTable');

        for (let i = 0; i < data.length; i++) {
            const row = `<tr>
                            <td>
                                <button onclick="location.href='/banner/page/' + ${data[i].id} ">${data[i].name}</button>
                            </td>
                       </tr>`;
            table.innerHTML += row
        }
    }

}

getBannerListData().then();