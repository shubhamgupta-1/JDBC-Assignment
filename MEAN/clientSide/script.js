$(document).ready(function () {
    getAllEmps();
    $('#btnSearchProduct').click(function () {
        var category = $('#searchId').val();
        var tableBody = $('#tblSearchResult tbody');
        $.ajax({
            url: 'http://localhost:8090/product/'+category,
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log(data);
                tableBody.empty();
                if(data){
                    $(data).each(function (index, element) {
                        tableBody.append('<tr><td>'+element.pname+'</td><td>'+element.price+'</td><td>'+element.category+'</td></tr>');
                    });
                }
                else{
                    tableBody.append(`<td colspan="3">No Search Results</td>`);
                }
            },
            error: function (error) {
                console.log('INAVLID CATEGORY')
            }
        })
        
    })
});

function getAllEmps() {
    $.ajax({
        url: 'http://localhost:8090/product',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            var tableBody = $('#tblProduct tbody');
            tableBody.empty();
            $(data).each(function (index, element) {
                tableBody.append('<tr><td>'+element.pname+'</td><td>'+element.price+'</td><td>'+element.category+'</td></tr>');
            })
        },
        error: function (error) {
            alert(error);
        }
    });
}

