function setRowListener(event) {
    if(!this.classList.contains('create')) {
        this.classList.add('ch');
    }
}

function addRow() {
    const tableBody = document.querySelector('.tbody');
    const addButton = document.querySelector('.add');
    const addListener = (event) => {
        const tr = document.createElement('tr');
        tr.classList.add('auction');
        tr.classList.add('create');
        tr.innerHTML = `<td>
                        <textarea class="input"></textarea>
                    </td>
                    <td>
                        <textarea class="input"></textarea>
                    </td>
                    <td>
                        <input type="checkbox" class="checkbox">
                    </td>
                    <td class="goTo">
                        
                    </td>`
        tableBody.append(tr);
        tr.addEventListener('input', setRowListener)

    }
    addButton.addEventListener("click", addListener);
}

function setSendListener() {
    const sendButton = document.querySelector('.send');
    const sendListener = () => {
        const rowChenged = document.querySelectorAll('.ch');
        rowChenged.forEach((el) => {
            const input = el.querySelectorAll('.input');
            const checkbox = el.querySelector('.checkbox');
            const status = checkbox.checked ? 'close' : 'open';
            const data = new URLSearchParams();
            data.append("name", input[0].value);
            data.append("description", input[1].value);
            data.append('status', status);
            data.append('id', el.dataset.id);

            fetch(`http://localhost:8081/auction?command=auction`, {
                method: 'POST',
                body: data.toString(),
                credentials: 'same-origin',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });

            el.classList.remove('ch');


        })

        const rowAdd = document.querySelectorAll('.create');
        rowAdd.forEach((el) => {
            const input = el.querySelectorAll('.input');
            const checkbox = el.querySelector('.checkbox');
            const status = checkbox.checked ? 'close' : 'open';
            const data = new URLSearchParams();
            data.append("name", input[0].value);
            data.append("description", input[1].value);
            data.append('status', status);
            data.append('id', el.dataset.id);

            fetch(`http://localhost:8081/auction?command=createdAuction`, {
                method: 'POST',
                body: data.toString(),
                credentials: 'same-origin',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            })
                .then(data => data.json())
                .then(data => {
                    const goToButton = el.querySelector('.goTo');
                    goToButton.innerHTML = `
                        <button data-id="${data.id}">auction</button>
                    `
                    el.classList.remove('create');
                });

        })
    }

    sendButton.addEventListener('click', sendListener);
}

function main() {
    const row = document.querySelectorAll('.auction');
    row.forEach((el) => {
        el.addEventListener('input', setRowListener)
    })
    addRow();
    setSendListener();
}

main();