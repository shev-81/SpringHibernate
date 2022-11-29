angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8000/hibernate/api/v1/students';

    $scope.loadStudents = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.StudentList = response.data;
            });
    };

    $scope.createStudent = function(){
        $http.post(contextPath, $scope.newStudent
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

    $scope.lookCourses = function (id) {
        $http.get(contextPath +'/student/' + id)
            .then(function (response) {
                $scope.Courses = response.data.coursesName;
            });
    }
    $scope.loadStudents();
});