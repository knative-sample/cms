# CMS
Deploy the MicroService by Knative and MSE
- portal-www. The UI of pc
- portal-mobile. The UI of mobile
- baseinfo. Base info of the company
- contactinfo. Contact info of the company

## Installing the Chart
To Install the cms chart:
    ```
    $ helm install chart --name cms
    ```
## Uninstalling the Chart

To uninstall/delete the `cms` release but continue to track the release:
    ```
    $ helm delete cms
    ```

To uninstall/delete the `cms` release completely and make its name free for later use:
    ```
    $ helm delete cms --purge
    ```