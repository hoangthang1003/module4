function loadBlogs(append) {
    let search= document.getElementById("idSearch").value;

    $.ajax({
        type: "GET",
        url: `http://localhost:8080/blog?author=`+search,
        header: {
            "Content-type": "application/JSON",
        },
        success: function (data) {
            renderBlogs(data.content, append);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


$(document).ready(function () {
    loadBlogs();
})

function renderBlogs(blogs, append) {
    let element = "";
    for (let blog of blogs) {
        element += `
  <div class="card col-sm-3" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${blog.name}</h5>
    <p class="card-text">${blog.content}</p>
    <p class="card-text">${blog.author}</p>
    <a href="#" class="btn btn-primary">Add</a>
  </div>
</div> 
         `;
    }

    if (append) {
        $("#listBlogs").append(element);
    } else {
        $("#listBlogs").html(element);
    }
}