function setCloseClass(auctions) {
    for(let i = 0; i < auctions.length; i++) {
        if(auctions[i].dataset.status == 'close') {
            auctions[i].classList.add('close');
        }
    }
}

async function setListener() {
    const table = document.querySelector(".tbody");
    const listener = async (event) => {
        // table.removeEventListener('click', listener);
        // TO DO
        window.location.href = `http://localhost:8081/auction?command=lots&id=${event.target.dataset.id}`;
    };
    table.addEventListener('click', listener);
}

function main() {
    const auctions = document.getElementsByClassName("auction");
    setCloseClass(auctions);
    setListener()
}

main();