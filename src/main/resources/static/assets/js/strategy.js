var strategy = new Vue({
    el: "#strategy",
    data: {
        beginList: [],
        advancedList: [],
        tacticList: []
    },
    mounted: function () {
        $.post("article/get", {"type": "4"}, function (data) {
            strategy.beginList = data;
        }, "JSON");
        $.post("article/get", {"type": "5"}, function (data) {
            strategy.advancedList = data;
        }, "JSON");
        $.post("article/get", {"type": "6"}, function (data) {
            strategy.tacticList = data;
        }, "JSON");
    }
});
