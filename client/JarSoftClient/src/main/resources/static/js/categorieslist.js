const hostName = window.location.protocol;
const api_url = hostName + '/categories';

async function getCategoryListData() {

    const response = await fetch(api_url); // как парсить json https://www.youtube.com/watch?v=uxf0--uiX0I
    const list = await response.json();

    buildTable(list)

    function buildTable(data) {
        const table = document.getElementById('myTable');

        for (let i = 0; i < data.length; i++) { // for each
            const row = `<tr>
                            <td>
                                <button onclick="location.href='/edit/category/page/' + ${data[i].id} ">${data[i].name}</button>
                            </td>
                       </tr>`;
            table.innerHTML += row
        }
    }

}

getCategoryListData().then();
