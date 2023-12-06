import sys
sys.path.append('C:/CodigosRed/python/AUDIOEJERCICIO')

import grpc
from concurrent import futures
import audio_pb2
import audio_pb2_grpc
from pydub import AudioSegment

class AudioStreamerServicer(audio_pb2_grpc.AudioServiceServicer):
    def __init__(self):
        self.audio_chunks = []  # Almacena los chunks de audio

    def StreamAudio(self, request_iterator, context):
        for chunk in self.audio_chunks:
            yield audio_pb2.AudioChunk(data=chunk)

def serve():
    servicer = AudioStreamerServicer()  # Crea una instancia de AudioStreamerServicer
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    audio_pb2_grpc.add_AudioServiceServicer_to_server(servicer, server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Servidor gRPC en ejecución en el puerto 50051 :)")

    # Leer el archivo MP3 y dividirlo en chunks
    audio = AudioSegment.from_mp3("CC:/CodigosRed/python/AUDIOEJERCICIO/NFLS.mp3")
    chunk_size_ms = 1000  # Tamaño de cada chunk en milisegundos
    for i in range(0, len(audio), chunk_size_ms):
        chunk = audio[i:i+chunk_size_ms]
        chunk_bytes = chunk.raw_data
        servicer.audio_chunks.append(chunk_bytes)  # Utiliza la instancia de servicer

    server.wait_for_termination()

if __name__ == "__main__":
    serve()
