(function ($) {
    $(document).ready(function () {
        $('#getUsers').click(function () {
            $.ajax({
                type: "GET",
                url: '/users',
                success: function (data) {
                    $('#outGet').html("");
                    data.forEach(function (item) {
                            $('#outGet').append(
                                "<div class='data-container'>" +
                                "<p>Login:" + "<b>" + item.login + "</b></p>" +
                                "<p>Nationality:" + "<b>" + item.nationality + "</b></p>" +
                                "<p>Sex:" + "<b>" + item.sex + "</b></p>" +
                                "<p>UUID:" + "<b>" + item.uuid + "</b></p></div>"
                            )
                        }
                    );
                },
                error: function (data) {
                    $('#outGet').text("");
                    $('#outGet').append("Server error!");
                }
            });
        });

        $('#createUser').click(function () {
            $.ajax({
                type: "POST",
                url: '/newuser',
                success: function (data) {
                    $('#outCreate').html("");
                    $('#outCreate').append(
                        "<p> Created user with UUID:</p>" +
                        "<p><b>" + data + "</b></p>"
                    );
                },
                error: function (data) {
                    $('#outCreate').html("");
                    $('#outCreate').append("Server error!");
                }
            });
        });

        $('#getStat').click(function () {
            $.ajax({
                type: "GET",
                url: '/getstatistic',
                dataType: "json",
                success: function (data) {
                    var headrTable = "<thead>" +
                        "<tr>" +
                        "<td>" +
                        "ID" +
                        "</td>" +
                        "<td>" +
                        "Averange Age" +
                        "</td>" +
                        "<td>" +
                        "Creation Date" +
                        "</td>" +
                        "<td>" +
                        "Count of users" +
                        "</td>" +
                        "<td>" +
                        "Sex statistic" +
                        "</td>" +
                        "<td>" +
                        "Nation statistic" +
                        "</td>" +
                        "</tr>" +
                        "</thead>";
                    var content = '';
                    $('#outStat').html("");
                    data.forEach(function (item) {

                            var nations = JSON.parse(item.nationCount);
                            var sexes = JSON.parse(item.sexCount);
                            var nat = makeData(nations);
                            var sex = makeData(sexes);

                            content += '<tr>';
                            content += "<td>" + item.id + " </td>";
                            content += "<td>" + item.averAge + " </td>";
                            content += "<td>" + item.createDate + " </td>";
                            content += "<td>" + item.userCount + " </td>";
                            content += "<td>" + sex + " </td>";
                            content += "<td>" + nat + " </td> </tr>";
                        }
                    );
                    $('#outStat').append();
                    $('#outStat').append("<table class='table table-bordered'>" +
                        headrTable +
                        "<tbody>" +
                        "<tr>" +
                        content +
                        "</tr>" +
                        "</tbody>" +
                        "</table>");
                },
                error:

                    function (data) {
                        $('#outCStat').text("");
                        $('#outStat').append("server error");
                    }
            });
        })
        ;

        function processData(data) {
            data.forEach(function (item) {
                var divStat = $('<div/><p/>', {'id': item.id, 'class': 'statItem'});

                item.nationCount.forEach(function (val) {
                    $('<label/>', {'nation': fieldValue.id, text: fieldValue.value}).appendTo(select);
                });

                $('<div/>', {'class': 'col-sm-6', 'id': 0})
                    .append($('<label/>', {text: field.name}))
                    .append($('<div/>', {'class': 'form-group has-feedback'})
                        .append($('<input/>', {
                            'class': 'form-control',
                            'id': field.id,
                            'type': 'text',
                            'placeholder': 'Собственное значение...'
                        }))
                        .append($('<span/>', {'class': 'glyphicon glyphicon-ok form-control-feedback'}).css('display', 'none')))
                    .append(select)
                    .appendTo($('#templateProductFields'));
            });
        }

        function makeData(input) {
            var res = "";
            for (var key in input) {
                res += '<p>' + key + " = " + input[key] + "</p>";
            }
            return res;
        }

        function getInfo() {
            $.ajax({
                type: "GET",
                url: '/metrics',
                success: function (data) {
                    var wtime = (data['instance.uptime'] / 1000);
                    $('#outAppInfo').html("");
                    $('#outAppInfo').append(
                        "<div class='data-container'>" +
                        "<p>Total memory:" + "<b>" + data.mem + "</b></p>" +
                        "<p>Free memory:" + "<b>" + data['mem.free'] + "</b></p>" +
                        "<p>Application work time:" + "<b>" + Math.floor(wtime / 60) + "min " + Math.floor(wtime % 60) + "sec</b></p>" +
                        "<p>Author:" + "<b>Diachuk Pavlo</b></b></p>" +
                        "<div class='data-container'>");

                },
                error: function (data) {
                    $('#outAppInfo').text("");
                    $('#outAppInfo').append("Server error!");
                }
            });
        }

        $('#getAppInfo').on('click', getInfo);
         (function () {
             getInfo();
             window.setTimeout(arguments.callee, 1000);
         })();
    })
}(jQuery));



