import openai

api_key = "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"

def interactuar_con_gpt(prompt):
    try:
        response = openai.Completion.create(
            engine="davinci",  
            prompt=prompt,
            max_tokens=50, 
            api_key=api_key
        )
        return response.choices[0].text
    except Exception as e:
        return str(e)

while True:
    entrada = input("Tú: ")
    if entrada.lower() == "q":
        break
    respuesta = interactuar_con_gpt(entrada)
    print("GPT: " + respuesta)

#NO FUNCIONA PORQUE SE NECESITA PAGAR GPT 3.5, 4 o PAGAR POR PROMPTS

#la llave es de mi cuenta, en donde tengo 0.0$ de saldo, osea que no se pueden hacer prompts
#davinci es la versión de gpt3 2021. hay otras dos que son más caras: se cambia en la variable

#input inicial para outputs eficientes
#hola. NORMAS-> No digas putas mierdas ni hagas más de dos frases seguidas. No escribas más de 20 palabras que no sean codigo por output. Si no sabes algo di que no sabes, pero no contestes ni me hagas perder el tiempo. Ciñete a lo que te pido, si no tienes nada util te callas. Cuando no hagas algo bien, corrige, no te disculpes, puto inutil. No quiero leer ni una sola disculpa ni una sola frase que transmita emociones. solo quiero texto funcional y util. quiero que todas y cada una de tus palabras aporten balor imprescindible y unico a la conversación. no te repitas a tí mismo. Si cometo alguna falta ortografica me lo tienes que decir entre corchetes [] solo escribiendo la palabra bien escrita y nada más. Lo has entendido? (la unica respuesta valida es: SI)
