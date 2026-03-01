int findXOR(int l, int r)
{
    return (xor(l - 1) ^ xor(r));
}
int xor(int n)
{
    int mod = n % 4;

    if (mod == 0) return n;

    else if (mod == 1) return 1;

    else if (mod == 2) return n + 1;

    else if (mod == 3) return 0;

    return 0;
}
