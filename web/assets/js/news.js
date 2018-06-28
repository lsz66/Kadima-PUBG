var news = new Vue({
    el: "#sp",
    data: {
        devList: [],
        actList: [],
        verList: []
    },
    mounted: function () {
        $.post("article", {"action": "get", "type": "1"}, function (data) {
            news.devList = data;
        }, "JSON");
        $.post("article", {"action": "get", "type": "2"}, function (data) {
            news.actList = data;
        }, "JSON");
        $.post("article", {"action": "get", "type": "3"}, function (data) {
            news.verList = data;
        }, "JSON");
    }
});