<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boulangerie NyMofoko</title>
    <style>
        /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .welcome-container {
            position: relative;
            text-align: center;
            overflow: hidden;
            height: 100vh;
        }

        .welcome-text {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: 3rem;
            font-weight: 700;
            color: white;
            /*text-shadow: 2px 4px 6px rgba(0, 0, 0, 0.5);*/
            background: linear-gradient(45deg, #a87624, #ff7043);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            animation: fadeIn 2s ease-in-out;
        }

        .welcome-image {
            width: 100%;
            height: auto;
            object-fit: cover;
            filter: brightness(70%);
        }

        /* Button for Action */
        .welcome-button {
            position: absolute;
            top: 70%;
            left: 50%;
            transform: translateX(-50%);
            padding: 15px 30px;
            background: linear-gradient(45deg, #ff7043, #a2701e);
            color: white;
            border: none;
            border-radius: 25px;
            font-size: 1.2rem;
            font-weight: bold;
            cursor: pointer;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .welcome-button:hover {
            transform: scale(1.1);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
        }

        /* Fade-in Animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translate(-50%, -60%);
            }
            to {
                opacity: 1;
                transform: translate(-50%, -50%);
            }
        }
    </style>
</head>
<body>
<div class="welcome-container">
    <img src="/assets/images/test2.png" alt="Image de boulangerie" class="welcome-image">
    <div class="welcome-text">Bienvenue sur le site de la boulangerie NyMofoko</div>
    <button class="welcome-button">Explorer Maintenant</button>
</div>
</body>
</html>
