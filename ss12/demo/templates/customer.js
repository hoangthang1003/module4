function loadCustomers() {

    $.ajax({
        type: "GET",
        url: `http://localhost:8080/customer`,
        header: {
            contentType: 'application/json',
        },
        success: function (data) {
            renderCustomers(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


$(document).ready(function () {
    loadCustomers();
    listAllType();
    createCustomers();
})

function renderCustomers(customers) {
    let element = "";
    for (let customer of customers) {
        element += `


      <tr>
        <td>${customer.id}</td>
        <td>${customer.customer}</td>
        <td>${customer.customerType?.name}</td>
        <td>${customer.dateOfBirth}</td>
<!--        <td><button type="button"-->
<!--                class="btn btn-primary"-->
<!--                data-toggle="modal" data-target="#exampleModalCreate"-->
<!--                >-->
<!--               Edit-->
<!--              </button></td>-->
        <td><button type="button"
                class="btn btn-danger"
                data-toggle="modal" data-target="#exampleModal"
                onclick="getCustomerInfo(${customer.id}, '${customer.customer}')">
               Xóa
              </button></td>
        
      </tr>
         `;
    }




    $("#listCustomer").html(element);

}

function getCustomerInfo(id,name) {
    document.getElementById("deleteId").value = id;
    document.getElementById("deleteName").innerText = "Xóa Customer " + name;
}


$("#delete-customer").submit(
    function (event) {
        event.preventDefault();
        let id = $("#deleteId").val();
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


function createCustomer(name,birth ,img,customerType) {
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
                img: img,
                customerType: {id:customerType}
            }
        ),
        success: () => {
            loadCustomers()
        },
        error: (error) => {
            console.log(error);
        }
    })
}

$('#createCustomerForm').click(() =>{
    debugger
    let name = $("#name").val();
    let birth = $("#birth").val();
    let img = $("#img").val();
    let customerType = $("#customerType").val();
    createCustomer(name,birth,img,customerType);
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
    for (let type of customerType){
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


function createCustomers() {
    let element1 = "";
    element1 += `
   <div class="moda l-body">
                        <div>
                            <label>Tên khách hàng</label>
                            <input type="text" id="name" placeholder="Nhập tên" required>
                            <label>Ngày sinh</label>
                            <input  type="text" id="birth" placeholder="Nhập ngày sinh" required>
                            <label>Img</label>
                            <input type="text" id="img">
                            <label>Kiểu khách hàng</label>
                            <div id="customerTypeForm"></div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-danger" id="createCustomerForm">Save</button>
                </div>
                `;

    $("#create-customer").html(element1);

}
