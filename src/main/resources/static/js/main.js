function errorHandler() {
    let errorNick = document.getElementById("error2").value;
    let errorSeason = document.getElementById("error1").value;
    if(errorNick === "true"){
        alert("nickname is not correct");
    }else if(errorSeason === "true"){
        alert("not games in season selected");
    }
}

function imageRank() {
    var rankToImage = document.getElementById("tier").innerText.replace(' ', '-');
    var elementRank = document.getElementById("imageTierPng");
    var path = "img/" + rankToImage + ".png";

    elementRank.src = (path);
}

function redirect() {
    let text = document.getElementById("title-main");
    
    text.onclick = (window.location.href = "http://localhost:8080/");
}


