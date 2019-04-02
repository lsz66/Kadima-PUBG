var lsz = new Vue({
    el: "#news",
    data: {
        newsList: []
    },
    mounted: function () {
        $.get("/article/getNews", {}, function (data) {
            lsz.newsList = data;
        }, "JSON");
    },
    methods: {
        del: function (id) {
            layer.confirm("您确定要删除这篇新闻吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.ajax({
                        url: "/article",
                        data: {"id": id},
                        method: 'delete',
                        success: () => {
                            location.reload();
                        }
                    });
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
    $("#newsTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [2, 5, 6]}]
    });
});