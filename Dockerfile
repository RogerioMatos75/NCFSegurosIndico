FROM openjdk:11-jdk

# Instalar dependências necessárias
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# Instalar Android SDK
RUN wget -q https://dl.google.com/android/repository/commandlinetools-linux-6858069_latest.zip -O android-sdk.zip \
    && unzip android-sdk.zip -d /usr/local/android-sdk \
    && rm android-sdk.zip

ENV ANDROID_HOME /usr/local/android-sdk
ENV PATH $ANDROID_HOME/cmdline-tools/bin:$PATH

# Aceitar licenças do Android SDK
RUN yes | sdkmanager --licenses

# Instalar pacotes do Android SDK
RUN sdkmanager "platform-tools" "platforms;android-30" "build-tools;30.0.3"

# Configurar diretório de trabalho
WORKDIR /workspace

# Copiar arquivos do projeto
COPY . /workspace

# Comando padrão
CMD ["./gradlew", "build"]
