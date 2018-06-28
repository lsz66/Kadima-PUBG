var lsz = new Vue({
    el: "#strategy",
    data: {
        strategyList: []
    },
    mounted: function () {
        $.post("/article", {"action": "getStrategy"}, function (data) {
            lsz.strategyList = data;
        }, "JSON");
    },
    methods: {
        del: function (id) {
            layer.confirm("您确定要删除这篇攻略吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.post("/article", {"action": "del", "id": id}, function () {
                        location.reload();
                    }, "text");
                });
        },
        show: function (content) {
            layer.open({
                type: 1,
                skin: "layui-layer-rim",
                area: ["800px", "600px"],
                content: content
            });
        }
    }
});
$(function () {
    $("#strategyTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [2, 5, 6]}]
    });
});