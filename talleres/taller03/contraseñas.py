def permutations(base, str):
    if len(str) == 0:
        print(base)
    else:
        i = 0
        while i < len(str):
            permutations(base + str[i], str[0:i] + str[i+1:])
            i = i + 1

permutations("", "abcd")