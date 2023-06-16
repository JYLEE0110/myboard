const button = document.querySelector(".deleteButton");
const button2 = document.querySelector(".modifyButton")
const button3 = document.querySelector(".listButton")
const actionForm = document.querySelector(".form-horizontal");

const {tno} = [[${boardDTO}]]

button.addEventListener("click", (e) => {
    actionForm.setAttribute("action", `/board/delete/${tno}`)
    actionForm.submit();
})

button2.addEventListener("click", (e) => {
    actionForm.setAttribute("action", `/board/modify/${tno}`)
    actionForm.setAttribute("method", `get`)
    actionForm.submit();
})

button3.addEventListener("click", (e) => {
    actionForm.setAttribute("action", `/board/list`)
    actionForm.setAttribute("method", `get`)
    actionForm.submit();
})