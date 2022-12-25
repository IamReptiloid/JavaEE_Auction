export function send(command, property) {
    return fetch(`http://localhost:8081/auction?command=${command}`, {
        method: 'POST',
        body: property.toString(),
        credentials: 'same-origin',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    })
}

export function execute(command, property) {
    return fetch(`http://localhost:8081/auction?command=${command}`, {
        method: 'GET',
        body: property.toString(),
        credentials: 'same-origin',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    })
}