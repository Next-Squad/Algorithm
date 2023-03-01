import sys
input = sys.stdin.readline

if __name__ == '__main__':
  h, w, n, m = map(int, input().split())
  vert = (h // (n+1))
  hori = (w // (m+1))
  if ((h // (n+1)) * (n+1)) < h:
    vert += 1
  if ((w // (m+1)) * (m+1)) < w:
    hori += 1
  print(vert * hori)
