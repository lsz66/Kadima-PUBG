var news = new Vue({
    el: "#sp",
    data: {
        devList: [],
        actList: [],
        verList: []
    },
    mounted: function () {
        $.post("article/get", {"type": "1"}, function (data) {
            news.devList = data;
        }, "JSON");
        $.post("article/get", {"type": "2"}, function (data) {
            news.actList = data;
        }, "JSON");
        $.post("article/get", {"type": "3"}, function (data) {
            news.verList = data;
        }, "JSON");
    }
});