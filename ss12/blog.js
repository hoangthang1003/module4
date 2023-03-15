function loadProducts(append){
    // let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog`,
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => {
            renderProducts(data.content,append);
            // renderLoadMoreButton(data);
        },
        error: (error) => {
            console.log(error);
        },
    });
}
$(document).ready(() => loadProducts());

function renderProducts(blogs,append){
    let elements = "";
    for(let blog of blogs){
        elements += `
        <div class="card">
      
     
         <h5 class="card-title">${blog.name}</h5>
         <h5 class="card-title">${blog.content}</h5>
            <p class="card-text">${blog.author}</p>
            <a href="#" class="btn btn-primary">Add New</a>
        </div>
        </div>
        `;
    }
    append ? $("#listProducts").append(elements) : $("#listProducts").html(elements);
}

function loadMore(nextPage){
    loadProducts(nextPage,true);
}
function renderLoadMoreButton(blogPageData){
    if(blogPageData.number < blogPageData.totalPages-1){
        $("#loadMoreContainer").html(
            `
        <button type="button" class="btn btn-dark"
         onclick="loadMore(${blogPageData.number + 1})">
         Xem thêm...</button>
         `
        );
    }else{
        $("#loadMoreContainer").remove();
    }
}