const hostName = window.location.protocol;
document.addEventListener('submit', function (event) {

    event.preventDefault();

    fetch('http://localhost:8080/add/banner', {
        method: 'POST',
        body: JSON.stringify(Object.fromEntries(new FormData(event.target))),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    }).then(function (response) {
        if (response.ok) {
            return response.json();
        }
        return Promise.reject(response);
    })
});