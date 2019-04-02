var news = new Vue({
    el: "#sp",
    data: {
        devList: [],
        actList: [],
        verList: []
    },
    mounted: function () {
        $.get("article", {"type": "1"}, function (data) {
            news.devList = data;
        }, "JSON");
        $.get("article", {"type": "2"}, function (data) {
            news.actList = data;
        }, "JSON");
        $.get("article", {"type": "3"}, function (data) {
            news.verList = data;
        }, "JSON");
    }
});