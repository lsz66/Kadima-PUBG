var lsz = new Vue({
    el: "#video",
    data: {
        videoList: []
    },
    mounted: function () {
        $.post("/video", {"action": "get"}, function (data) {
            lsz.videoList = data;
        }, "JSON");
    },
    methods: {
        del: function (id) {
            layer.confirm("您确定要删除这个视频吗？",
                {btn: ["好der", "不了"]}, function () {
                    $.post("/video", {"action": "del", "id": id}, function () {
                        location.reload();
                    }, "text");
                });
        },
        showPath: function (path) {
            layer.alert("视频地址：<br/>" + path)
        }
    }
});
$(function () {
    $("#videoTable").DataTable({
        language: {url: "js/Chinese.json"},
        aoColumnDefs: [{"bSortable": false, "aTargets": [2, 5, 6]}]
    });
});