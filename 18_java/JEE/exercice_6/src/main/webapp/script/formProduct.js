document.addEventListener("DOMContentLoaded", () => {
    let btn = document.getElementById("submit-form")
    let mainForm = document.getElementById("main-form")
    let fileForm = document.getElementById("file-form")

    const submit = (event) => {
        event.preventDefault()
        fileForm.submit()
        mainForm.submit()
    }

    btn.addEventListener("click", (e) => submit(e))

    document.addEventListener("keypress", (e) => {
        if (e.key === "Enter") submit(e)
    })
})