const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    /*

    QUẢN LÝ GIỎ HÀNG
    */

    $scope.cart = {
        items: [],
        //     //Thêm sản phẩm vào giỏ hàng
        add(id) {
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                    // alert("Add to cart successfully!");

                })
            }
        },
        //     //Xoá sản phẩm khỏi giỏ hàng
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        // //Xoá sạch các mặt hàng trong giỏ
        clear() {
            this.items = []
            this.saveToLocalStorage();
        },
        // //Tính thành tiền của 1 sản phẩm

        //Tính tổng số lượng các hàng trong giỏ
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        //Tổng thành tiền các mặt hàng trong giỏ
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        //     //Lưu giỏ hàng vào local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        //Đọc giỏ hàng từ local storage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }


    // Tải lại toàn bộ các mặt hàng đã lưu trong loadFromLocalStorage() vào trong cart
    $scope.cart.loadFromLocalStorage();

    $scope.order = {
        createDate: new Date(),
        action: "Chưa xác nhận",
        account: { username: $("#username").text() },
        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: { id: item.id },
                    price: item.price,
                    quantity: item.qty,
                    size: item.size
                }
            });
        },


        purchase() {
            var order = angular.copy(this);
            if ($scope.cart.count == 0) {
                alert("Please add product to cart!")
                console.log(error)
            } else {
                //thực hiện đặt hàng
                $http.post("/rest/orders", order).then(resp => {
                    alert("Order successfully!");
                    $scope.cart.clear();
                    location.href = "/order/detail/" + resp.data.id;
                }).catch(error => {
                    alert("Please fill in your delivery address, phone number and size!")
                    console.log(error)
                })
            }

        }

    }


})