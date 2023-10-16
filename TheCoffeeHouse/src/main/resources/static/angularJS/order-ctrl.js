app.controller("order-ctrl", function ($scope, $http) {

    $scope.orderdetails = [];
    $scope.orders = [];
    $scope.form = {};

    $scope.initialize = function () {

        // Load order
        $http.get("/rest/orders").then(resp => {
            $scope.orders = resp.data;
            
        });

        //  // Load orderDetail
        $http.get("/rest/orderdetails").then(resp => {
            $scope.orderdetails = resp.data;
        });
    }

    //Khởi Đầu
    $scope.initialize();

    //hien thi len form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
    }
    //hien thi Order Detail
    $scope.view = function (item) {
        $scope.form = angular.copy(item);
        $http.get(`/rest/orderdetails/${item.id}`).then(resp => {
            $scope.orderdetails = resp.data;
        });
        $(".nav-tabs a:eq(0)").tab('show');
    }


    //cap nhat action
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/orders/${item.id}`, item).then(resp => {
            var index = $scope.orders.findIndex(p => p.id == item.id);
            $scope.orders[index] = item;
            //Khởi Đầu
            $scope.initialize();
            alert("Done !");
            $(".nav-tabs a:eq(1)").tab('show');

        }).catch(error => {
            alert("Error !");
            console.log("Error", error);
        });
    }


    //xoa sp
    $scope.delete = function (item) {
        $http.delete(`/rest/orders/${item.id}`).then(resp => {
            var index = $scope.orders.findIndex(o => o.id == item.id);
            $scope.orders.splice(index, 1);
            alert("Hủy đơn hàng thành công !");
            $(".nav-tabs a:eq(1)").tab('show');

        }).catch(error => {
            alert("Có Lỗi  !");
            console.log("Error", error);
        });
    }




    $scope.pageDetail = {
        page: 0,
        size: 7,
        get orderdetails() {
            var start = this.page * this.size;
            return $scope.orderdetails.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.orderdetails.length / this.size);

        },

        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }


});