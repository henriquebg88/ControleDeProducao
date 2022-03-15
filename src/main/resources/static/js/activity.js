let nullfyTextAreaCheckBoxHTML  = document.querySelector(".form-check-input");
let textArea                    = document.querySelector("textarea");

console.log(nullfyTextAreaCheckBoxHTML);

nullfyTextAreaCheckBoxHTML.addEventListener("click", () => {
    console.log("Clicado");
    textArea.toggleAttribute("disabled");
});
    