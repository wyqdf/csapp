#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n, s;
    cin >> n >> s;
    vector<int> p(n + 1);
    vector<int> c(i + 1);
    int max1 = -1, max2 = -1;
    int p1 = 0;
    for (int i = 1; i <= n; i++)
    {
        cin >> p[i] >> c[i];
        if (c[i] > max1)
        {
            max2 = max1;
            max1 = c[i];
            p1 = p[i];
        }
        else if (c[i] > max2)
        {
            max2 = c[i];
        }
    }
    if (max2 == -1)
    {
        cout << p[1] * c[1];
    }
    else
    {
        cout << max2 * s + (max1 - max2) * p1;
    }

    return 0;
}