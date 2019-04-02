var strategy = new Vue({
    el: "#strategy",
    data: {
        beginList: [],
        advancedList: [],
        tacticList: []
    },
    mounted: function () {
        $.get("article", {"type": "4"}, function (data) {
            strategy.beginList = data;
        }, "JSON");
        $.get("article", {"type": "5"}, function (data) {
            strategy.advancedList = data;
        }, "JSON");
        $.get("article", {"type": "6"}, function (data) {
            strategy.tacticList = data;
        }, "JSON");
    }
});
