function loadCustomers(page) {

    $.ajax({
        type: "GET",
        url: `http://localhost:8080/customer?page=${page ? page : "0"}`,
        header: {
            contentType: 'application/json',
        },
        success: function (data) {
            renderCustomers(data);
            renderPage(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function movePage(nextPage) {
    loadCustomers(nextPage);
}

function renderPage(customers) {
    let page = "";
    if (customers.number == customers.totalPages - 1 && customers.number > 0) {
        page += `
    <button class="page-item btn btn-primary btn-sm" 
    onclick="movePage(${customers.number - 1})">
    Before
    </button>
    `
    }
    for (let i = 1; i <= customers.totalPages; i++) {
        let pageItem = $(`<button class="page-item number btn btn-primary btn-sm"
                      onclick="movePage(${i - 1})">
                      ${i}
                      </button>`);
        if (i === customers.number + 1) {
            pageItem.addClass("active");
        } else {
            pageItem.removeClass("active");
        }
        page += pageItem.prop('outerHTML');
    }

    if (customers.number == 0 && customers.number < customers.totalPages) {
        page += `
    <button class="page-item btn btn-primary btn-sm" 
    onclick="movePage(${customers.number + 1})">
    Next
    </button>
    `
    }
    $("#paging").html(page);
}



function showById(id) {
    $.ajax({
        type:"GET",
        url:`http://localhost:8080/customer/` + id,
        header:{
            contentYpe : 'application/json',
        },
        success: function (data) {

        },
        error: function (error) {
            console.log(error);
        }
    })
}



$(document).ready(function () {
    loadCustomers();
    listAllType();
    showById()
})
function renderCustomerById(customer) {
    let element = "";


}

function renderCustomers(customers) {
    let element = "";
    for (let customer of customers) {
        element += `


      <tr>
        <td>${customer.id}</td>
        <td>${customer.customer}</td>
        <td>${customer.address}</td>
        <td>${customer.idCard}</td>
        <td>${customer.phoneNumber}</td>
        <td>${customer.customerType?.name}</td>
        <td>${customer.dateOfBirth}</td>
        <td><button type="button"
                class="btn btn-primary"
                data-toggle="modal" data-target="#exampleModalEdit"
                                onclick="getCustomerInfo('${customer.id}', '${customer.customer}')"

                >
               Edit
              </button></td>
        <td><button type="button"
                class="btn btn-danger"
                data-toggle="modal" data-target="#exampleModal"
                onclick="getCustomerInfo('${customer.id}', '${customer.customer}')">
               Xóa
              </button></td>
        
      </tr>
         `;
    }




    $("#listCustomer").html(element);

}

function getCustomerInfo(id,name) {
    document.getElementById("id").value = id;
    document.getElementById("nameCustomer").innerText = "Xóa Customer " + name;
}


$("#delete-customer").submit(
    function (event) {
        event.preventDefault();
        let id = $("#id").val();
        deleteCustomer(id);
    });

function deleteCustomer(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/customer/`+id,
        success: function (data) {
            console.log("Xóa thành công");

            loadCustomers();

            $('#exampleModal').hide();
            $('body').removeClass('modal-open');
            $('.modal-backdrop').remove();
        },
        error: function (error) {
            console.log("Lỗi, không xóa được");
        },
    });
}


function createCustomer(name,address,idCard,phoneNumber,birth ,img,customerType) {
    $.ajax({
        type: "POST",
        url: `http://localhost:8080/customer`,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(
            {
                customer:name,
                dateOfBirth: birth,
                address: address,
                idCard: idCard,
                phoneNumber: phoneNumber,
                img: img,
                customerType: {id:customerType}
            }
        ),
        success: () => {
            alert("Thêm khách hàng thành công!");
            $('#modelId').hide();
            $('body').removeClass('modal-open');
            $('.modal-backdrop').remove();
            loadCustomers()

        },
        error: () => {
            alert("lỗi không thêm được");
        }
    })
}

$('#createCustomerForm').submit(() =>{

    let name = $("#name").val();
    let address = $("#address").val();
    let idCard = $("#idCard").val();
    let phoneNumber = $("#phoneNumber").val();
    let birth = $("#birth").val();
    let img = $("#img").val();
    let customerType = $("#customerType").val();
    createCustomer(name,address,idCard,phoneNumber,birth,img,customerType);
})

// list all customer type
const listAllType = () => {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/customer/customerType`,
        header:{
            contentType: 'application/json',
        },
        success: (data) => {
            allCustomerType(data);
        },
        error: (error) => {
            console.log(error)
        }
    })
}

const allCustomerType = (customerType) => {
    let element = `<select id="customerType">`
    for (let type of customerType) {
        element += `<option value="${type.id}">${type.name}</option>`
    }
    element += `</select>`;

    $("#customerTypeForm").html(element);
}



//  <div class="card col-sm-3" style="width: 18rem;">
//   <img src="${customer.img}" class="card-img-top" alt="...">
//   <div class="card-body">
//     <h5 class="card-title">${customer.customer}</h5>
//     <p class="card-text">${customer.dateOfBirth}</p>
//     <p class="card-text">${customer.customerType?.name}</p>
//     <a href="#" class="btn btn-primary">Add</a>
//   </div>
// </div>




