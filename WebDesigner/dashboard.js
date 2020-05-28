let main = document.querySelector("main");
let plusElement = createPlusElement();
main.append(plusElement);

function createPlusElement(){

    let nextElement = document.createElement("div");
    nextElement.setAttribute("class", "raumverlinkungen");
    nextElement.append("+");

    nextElement.addEventListener("click", function(){
        let buttonLable = prompt("Wie soll der neue Button heißen?");
        //let newUrl = prompt("Wie lautet der Link für den neuen Button?");
        let newUrl = "http://" + prompt("Wie lautet der Link für den neuen Button?");

        let newElement = document.createElement("div");
        newElement.setAttribute("class", "raumverlinkungen");
        
        let link = document.createElement("a");
        link.append(buttonLable);
        link.setAttribute("href", newUrl);
        newElement.append(link);
        
        nextElement.before(newElement);
    });

    return nextElement;
}
