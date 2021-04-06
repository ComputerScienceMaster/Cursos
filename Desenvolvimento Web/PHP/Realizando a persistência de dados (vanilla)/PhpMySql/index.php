
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inserindo no banco de dados</title>
    </head>
    <?php
    if (isset($_POST['nome'])) {
        $servername = "localhost";
        $username = "root";
        $password = "12345";
        $dbname = "phpmysql";
        $conn = new mysqli($servername, $username, $password, $dbname);
        $nome = $_POST['nome'];
        $sql = "insert into pessoa (nome) values ('" . $nome . "');";

        if (!$conn) {
            die("Connection failed: " . mysqli_connect_error());
        }

        if ($conn->query($sql) === TRUE) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }

        $conn->close();
    }
    ?>
    <body>
        <form action="index.php" method="POST">
            <input name="nome" type="text" placeholder="Digite o nome"/>
            <input type="submit"> 
        </form>
    </body>
</html>
