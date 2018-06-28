var lsz = new Vue({
    el: "#home",
    data: {
        msgList: []
    },
    mounted: function () {
        $.post("/msg", {"action": "get"}, function (data) {
            lsz.msgList = data;
        }, "JSON");
    },
    methods: {
        del: function (id) {
            layer.confirm("您确定要删掉这条评论吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.post("/msg", {"action": "del", "id": id}, function () {
                        location.reload();
                    }, "text");
                });
        }
    }
});
$(function () {
    $("#msgTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [1, 2, 3, 4, 5]}]
    });
});