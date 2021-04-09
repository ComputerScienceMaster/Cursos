from chatterbot.trainers import ListTrainer
from chatterbot import ChatBot
import os

bot = ChatBot('Testing')

trainer = ListTrainer(bot)


for _file in os.listdir("C:/Users/Vinicius/Desktop/matheus/files"):
    print(_file)
    chats = open("C:/Users/Vinicius/Desktop/matheus/files/" + _file, 'r').readlines()
    trainer.train(chats)


    while True:
        request = input('you: ')
        response = bot.get_response(request)
        print('Bot: ', response)
        
        