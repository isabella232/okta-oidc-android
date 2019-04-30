/*
 * Copyright (c) 2019, Okta, Inc. and/or its affiliates. All rights reserved.
 * The Okta software accompanied by this notice is provided pursuant to the Apache License,
 * Version 2.0 (the "License.")
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the
 * License.
 */

package com.okta.oidc.clients.web;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import com.okta.oidc.OIDCConfig;
import com.okta.oidc.OktaState;
import com.okta.oidc.clients.AuthClientFactory;
import com.okta.oidc.net.HttpConnectionFactory;

public class SyncWebAuthClientFactory implements AuthClientFactory<SyncWebAuthClient> {
    @ColorInt
    private int mCustomTabColor;
    private String[] mSupportedBrowsers;

    public SyncWebAuthClientFactory() {
    }

    public SyncWebAuthClientFactory(int customTabColor) {
        mCustomTabColor = customTabColor;
    }

    public SyncWebAuthClientFactory(String... supportedBrowsers) {
        mSupportedBrowsers = supportedBrowsers;
    }

    public SyncWebAuthClientFactory(@ColorInt int customTabColor,
                                    @Nullable String... supportedBrowsers) {
        mCustomTabColor = customTabColor;
        mSupportedBrowsers = supportedBrowsers;
    }

    @Override
    public SyncWebAuthClient createClient(OIDCConfig oidcConfig,
                                          OktaState oktaState,
                                          HttpConnectionFactory connectionFactory) {
        return new SyncWebAuthClientImpl(oidcConfig, oktaState, connectionFactory,
                mCustomTabColor, mSupportedBrowsers);
    }
}
