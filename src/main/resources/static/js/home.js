
function reload() {
    fetch("http://localhost:8080/api")
        .then(response => {return response.json()})
        .then(quizzes => {

            let board = document.getElementById("quiz_board")
            for (let boardElement of board.children) board.removeChild(boardElement)

            for (let i = 0; i < quizzes.length; i++) {
                document.getElementById("quiz_board")
                    .appendChild(generateSmallQuizCard(quizzes[i]))
            }
        }).catch(error => {console.log(error)});
}

function generateSmallQuizCard(quiz) {
    let title = document.createElement("div")
    title.innerText = quiz.title
    title.classList.add("inner-text")

    let image = document.createElement("div")
    image.classList.add("background-image")
    image.src = quiz.imageUrl


    let card = document.createElement("div")
    card.classList.add("quiz_card")
    card.classList.add("quiz_small_card")
    card.appendChild(title)
    card.onclick  = () => {}

    return card
}

window.onload = ()=> {
    reload()
    document.getElementById("homeButton").onclick = reload;
}