angular.module('CricketApp')
// Creating the Angular Controller
    .controller('CricketController', function ($http, $scope, AuthService) {
        var edit = false;
        var init = function () {
            $http.get('/cricket').success(function (res) {
                $scope.records = res;
                $scope.editForm.$setPristine();
                $scope.addForm.$setPristine();
                $scope.message = '';
                $scope.currentCricket = null;
            }).error(function (error) {
                $scope.message = error.message;
            });
        };
        $scope.initEdit = function (cricket) {
            $scope.currentCricket = cricket;
            $scope.message = '';
        };
        $scope.initDelete = function(cricket) {
            $scope.currentCricket = cricket;
        };
        $scope.initAdd = function () {
            $scope.currentCricket = null;
            $scope.editForm.$setPristine();
            $scope.addForm.$setPristine();
            $scope.message = '';
        };
        $scope.delete = function () {
            $http.delete('/cricket/' + $scope.currentCricket.id).success(function (res) {
                $scope.deleteMessage = "Success!";
                init();
            }).error(function (error) {
                $scope.deleteMessage = error.message;
            });
        };
        $scope.editCricket = function () {
            $http.put('/cricket/' + $scope.currentCricket.id, $scope.currentCricket).success(function (res) {
                $scope.currentCricket = null;
                $scope.editForm.$setPristine();
                $scope.addForm.$setPristine();
                $scope.message = "Editing Success";
                init();
            }).error(function (error) {
                $scope.message = error.message;
            });
        };
        $scope.addCricket = function () {
            $http.post('/cricket', $scope.currentCricket).success(function (res) {
                $scope.currentCricket = null;
                $scope.editForm.$setPristine();
                $scope.addForm.$setPristine();
                $scope.message = "Cricket Created";
                init();
            }).error(function (error) {
                $scope.message = error.message + "\n" + error.details;
            });
        };
        init();

    });
