function loadProducts(page,append){
    let search= document.getElementById("idSearch").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog?page=${page ? page : "0"}&tittle=` + search,
        headers: {
            "Content-Type": "application/json",
        },
        success: function(data){
            renderProducts(data.content,append);
            renderLoadMoreButton(data);
        },
        error: function(error){
            console.log(error);
        },
    });
}
$(document).ready(function(){
    loadProducts();
});
function renderProducts(products,append){
    let elements = "";
    for(let product of products){
        elements += `
        <div class="card" style="width: 18rem;">
         <img src="${product.img}" class="card-img-top" alt="...">
            <div class="card-body">
         <h5 class="card-title">${product.tittle}</h5>
            <p class="card-text">${product.content}</p>
            <a href="#" class="btn btn-primary">Add New</a>
        </div>
        </div>
        `;
    }
    if(append){
        $("#listProducts").append(elements);
    }else{
        $("#listProducts").html(elements);
    }
}

function loadMore(nextPage){
    loadProducts(nextPage,true);
}
function renderLoadMoreButton(productPageData){
    if(productPageData.number < productPageData.totalPages-1){
        $("#loadMoreContainer").html(
            `
        <button type="button" class="btn btn-dark"
         onclick="loadMore(${productPageData.number + 1})">
         Xem thêm...</button>
         `
        );
    }else{
        $("#loadMoreContainer").remove();
    }
}