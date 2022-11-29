angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8000/students';

    $scope.loadStudents = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.StudentList = response.data;
            });
    };

    $scope.createStudent = function(){
//    console.log($scope.newStudent);
        $http.put(contextPath, $scope.newStudent
                ).then(function (response) {
                     $scope.loadStudents();
                });
    }


    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath +'/'+ studentId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.lookCourses = function (studentId) {
        $http.get(contextPath +'/courses/' + studentId)
            .then(function (response) {
                $scope.Courses = response.data;
            });
    }

    $scope.loadStudents();
});