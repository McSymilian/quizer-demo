class Quiz {
    id = 0;
    title = "";
    questions = [];
    constructor(json) {
        this.id = json.id
        this.title = json.title
        this.questions = json.questions
    }
}

function reload() {
    fetch("http://localhost:8080/api")
        .then(response => {return response.json()})
        .then(response => {
            let quizzes = []
            for (let i = 0; i < response.quizzes.length; i++)
                quizzes.push(new Quiz(response.quizzes[i]))

            return quizzes
        }).then(quizzes => {
            for (let i = 0; i < quizzes.length; i++) {
                document.getElementById("quiz_board")
                    .appendChild(generateSmallQuizCard(quizzes[i]))
            }
        }).catch(error => {console.log(error)});
}

function generateSmallQuizCard(quiz) {
    let card = document.createElement("div")
    card.innerText = quiz.title
    card.classList.add("quiz_small_card")
    card.onclick
    return card
}

function setQuizOnMain(contentDiv) {

}

window.onload = function() {
    reload()

    document.getElementById("homeButton").onclick = reload;
}