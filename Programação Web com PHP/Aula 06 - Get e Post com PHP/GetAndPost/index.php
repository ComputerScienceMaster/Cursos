<html>
    <head>
        <meta charset="UTF-8">
        <title>Página principal</title>
    </head>
    <body>
        
        <?php
            if(isset($_GET['name'])){
                echo ("<h3> parametro enviado por get: ". $_GET['name'] . "</h3>");
            }
            
            if(isset($_POST['name'])){
                echo ("<h3> parametro enviado por post: ". $_POST['name'] . "</h3>");
            }
        ?>
        <h1>usando get</h1>
        <form method="get">
            <input type="text" name="name" placeholder="Digite algo">
            <input type="submit" value="Submeter">
        </form>
        
        <h1>usando Post</h1>
        <form method="post">
            <input type="text" name="name" placeholder="Digite algo">
            <input type="submit" value="Submeter">
        </form>
    </body>
</html>
