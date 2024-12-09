deploy:
    if: ${{ github.ref == 'refs/heads/main' }}
    runs-on: ubuntu-latest
    needs:
      - docker-build
    steps:
      - uses: actions/checkout@v3
      - name: Add Server key
        run: |
          touch key.txt && echo "${{ secrets.SERVER_KEY }}" > key.txt
          chmod 600 key.txt
      - name: Deploy the application
        env:
          SERVER_HOST: ${{ secrets.SERVER_HOST }}
          SERVER_PORT: ${{ secrets.SERVER_PORT }}
          SERVER_USER: ${{ secrets.SERVER_USER }}
        run: |
          set -e
          ./deploy.sh