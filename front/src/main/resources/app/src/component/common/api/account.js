

export let register = (email, password, name) => {
    let body = {
        "email": email,
        "password": password,
        "name": name
    };
    return fetch("/api/account/register", {
        headers: {'Content-Type': 'application/json'},
        method: "POST",
        body: JSON.stringify(body)
    });
};

export let login = (email, password) => {
    let body = {
        "email": email,
        "password": password,
    };
    return fetch("/api/account/log-in", {
        headers: {'Content-Type': 'application/json'},
        method: "POST",
        body: JSON.stringify(body)
    });
};

