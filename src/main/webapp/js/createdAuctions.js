function setRowListener() {
    const row = document.querySelectorAll('.auction');
    const listener = function(event){
        this.classList.add('ch');
    }

    row.forEach((el) => {
        el.addEventListener('input', listener)
    })

    return [row, listener];
}

function setListener() {
    const addButton = document.querySelector('.add');
    const tableBody = document.querySelector('.tbody');
    let row = setRowListener();
    const addListener = (event) => {
        tableBody.innerHTML = tableBody.innerHTML + (`
            <tr class="auction create">
                    <td>
                        <textarea class="input"></textarea>
                    </td>
                    <td>
                        <textarea class="input"></textarea>
                    </td>
                    <td>
                        <input type="checkbox" class="checkbox">
                    </td>
                    <td>
                        
                    </td>
                </tr>
        `)
        for(let i = 0; i < row[0].length; i++) {
            row[0][i].removeEventListener('input', row[1]);
        }
        row = setRowListener();
    }
    addButton.addEventListener("click", addListener);

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

            fetch("http://localhost:8081/auction?command=createdAuction", {
                method: "POST",
                body: data.toString(),
                credentials: 'same-origin',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });

            el.classList.remove('ch');
        })
    }

    sendButton.addEventListener('click', sendListener);
}

function main() {
    setListener()
}

main();